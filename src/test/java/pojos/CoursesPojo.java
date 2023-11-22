package pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoursesPojo implements Serializable {
	private List<MobilePojo> mobile;
	private List<WebAutomationPojo> webAutomation;
	private List<ApiPojo> api;

}