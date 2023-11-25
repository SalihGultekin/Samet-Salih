package pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponsePojo implements Serializable {

	private CoursesPojo courses;
	private String instructor;
	private String services;
	private String linkedIn;
	private String expertise;
	private String url;

}