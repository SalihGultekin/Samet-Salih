package pojos;

import java.util.List;
import java.io.Serializable;

public class CoursesPojo implements Serializable {
	private List<MobilePojo> mobile;
	private List<WebAutomationPojo> webAutomation;
	private List<ApiPojo> api;

	public void setMobile(List<MobilePojo> mobile){
		this.mobile = mobile;
	}

	public List<MobilePojo> getMobile(){
		return mobile;
	}

	public void setWebAutomation(List<WebAutomationPojo> webAutomation){
		this.webAutomation = webAutomation;
	}

	public List<WebAutomationPojo> getWebAutomation(){
		return webAutomation;
	}

	public void setApi(List<ApiPojo> api){
		this.api = api;
	}

	public List<ApiPojo> getApi(){
		return api;
	}

	@Override
 	public String toString(){
		return 
			"CoursesPojo{" + 
			"mobile = '" + mobile + '\'' + 
			",webAutomation = '" + webAutomation + '\'' + 
			",api = '" + api + '\'' + 
			"}";
		}
}