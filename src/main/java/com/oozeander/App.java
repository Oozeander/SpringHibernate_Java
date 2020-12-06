package com.oozeander;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.oozeander.model.collection_enum_map.Gender;
import com.oozeander.model.collection_enum_map.User;
import com.oozeander.model.crud.Person;
import com.oozeander.model.embedded_attributeOverrides.Gamer;
import com.oozeander.model.embedded_attributeOverrides.GamerId;
import com.oozeander.model.embedded_attributeOverrides.GamerInformation;
import com.oozeander.model.inheritance.EpicGamesAccount;
import com.oozeander.model.inheritance.SteamAccount;
import com.oozeander.model.lob.Avatar;
import com.oozeander.model.lob.Subscriber;
import com.oozeander.model.mapping.Identity;
import com.oozeander.model.mapping.Professor;
import com.oozeander.model.mapping.Skill;
import com.oozeander.model.mapping.Student;
import com.oozeander.service.collection_enum_map.UserService;
import com.oozeander.service.crud.PersonService;
import com.oozeander.service.embedded_attributeOverrides.GamerService;
import com.oozeander.service.inheritance.AccountService;
import com.oozeander.service.lob.SubscriberService;
import com.oozeander.service.mapping.ProfessorService;
import com.oozeander.service.mapping.SkillService;
import com.oozeander.service.mapping.StudentService;
import com.oozeander.spring.JavaConfig;

import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class App {
    private static final Logger LOGGER;

    static {
        LOGGER = LogManager.getLogger(App.class);
    }
    public static void main(String[] args) {
        AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        ctx.registerShutdownHook();

		final String angular = "Angular", spring = "Spring", java = "Java", hibernate = "Hibernate",
			oozeander = "Oozeander", billel = "Billel", ketrouci = "KETROUCI";

        // CRUD
		PersonService personService = ctx.getBean(PersonService.class);
		List<Person> persons = Arrays.asList(new Person(billel, ketrouci, 24),
				new Person("El Bakay", "BOURAJOINI", 27), new Person("Meriem", "KECHEROUD", 25),
				new Person("Océane", "AKIYEMI", 24));
		persons.stream().forEach(personService::save);
		LOGGER.info(personService.get());
		personService.update(1L, new Person(oozeander, "Billel KETROUCI", 24));
		LOGGER.info(personService.get(1L));
		personService.delete(4L);
        LOGGER.info(personService.get());
        
		// ONE TO ONE / MANY TO ONE / MANY TO MANY
		StudentService studentService = ctx.getBean(StudentService.class);
		Identity identity = new Identity(billel, ketrouci, 24);
		List<Skill> skills = Arrays.asList(new Skill(java, 16), new Skill(hibernate, 16), new Skill(spring, 14),
				new Skill(angular, 11));
		Set<Professor> teachers = new HashSet<>(Arrays.asList(new Professor("English"), new Professor("Japanese")));
		Student student = new Student(identity, skills, teachers);
		identity.setStudent(student);
		skills.stream().forEach(skill -> skill.setStudent(student));
		teachers.stream().forEach(prof -> prof.setStudents(new HashSet<>(List.of(student))));

		studentService.save(student);
		LOGGER.info(studentService.get());
		LOGGER.info(ctx.getBean(SkillService.class).get());
		LOGGER.info(ctx.getBean(ProfessorService.class).get());

		// COLLECTION / ENUM / MAP
		UserService userService = ctx.getBean(UserService.class);
		userService
				.save(new User(
						List.of("billel.ketrouci@soprasteria.com", "billel.ketrouci@gmail.com",
								"billel.ketrouci@outlook.fr"),
						List.of(new Skill(java, 16), new Skill(angular, 11)), Gender.MALE,
						Map.of(java, 16, angular, 11)));
		LOGGER.info(userService.get());

		// EMBEDDED ID / EMBEDDED COMPONENT
		GamerService gamerService = ctx.getBean(GamerService.class);
		gamerService.save(new Gamer(new GamerId("11706818", oozeander, "XXXXXXXXX"),
				new GamerInformation(new HashSet<>(Arrays.asList("Rocket League", "Dark Souls 2", "Tales Of Berseria",
						"DB FighterZ", "MGS V : The Phantom Pain")))));
		LOGGER.info(gamerService.get(new GamerId("11706817", oozeander, "XXXXXXXX")));
		LOGGER.info(gamerService.get(new GamerId("11706818", oozeander, "XXXXXXXXX")));

		// INHERITANCE
		AccountService accountService = ctx.getBean(AccountService.class);
		Arrays.asList(new SteamAccount(2), new EpicGamesAccount(1)).stream().forEach(accountService::save);
		LOGGER.info(accountService.get());

		// LOB
		SubscriberService subscriberService = ctx.getBean(SubscriberService.class);
		subscriberService.save(new Subscriber(1L, billel, ketrouci, getAvatar("D:\\meuf.jpg")));
		LOGGER.info(subscriberService.get(1L));
		subscriberService.setAvatar(1L, "C:\\Users\\bille\\Desktop");

        ctx.close();
	}
	
	private static Avatar getAvatar(String path) {
		Avatar avatar = new Avatar(FilenameUtils.getName(path), FilenameUtils.getExtension(path));
		File file = new File(path);
		byte[] img = new byte[(int) file.length()];
		try {
			FileInputStream inputStream = new FileInputStream(file);
			inputStream.read(img);
			inputStream.close();
			StringBuilder fileSize = new StringBuilder();
			fileSize.append(Files.size(Paths.get(path)) / 1024).append(" Ko");
			avatar.setFileSize(fileSize.toString());
			avatar.setFileData(BlobProxy.generateProxy(img));
		} catch (IOException ex) {
			LOGGER.info("Error in Avatar loading : {}", ex.getLocalizedMessage());
		}
		return avatar;
	}
}