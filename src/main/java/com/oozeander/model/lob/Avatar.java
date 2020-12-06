package com.oozeander.model.lob;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Embeddable
public class Avatar {
	@NonNull
	@Column(name = "file_name")
	private String fileName;
	@NonNull
	@Column(name = "file_type")
	private String fileType;
	@Column(name = "file_size")
	private String fileSize;
	@Lob
	@Column(name = "file_data")
	private Blob fileData;
}