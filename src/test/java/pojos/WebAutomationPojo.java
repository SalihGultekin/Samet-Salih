package pojos;

import java.io.Serializable;

public class WebAutomationPojo implements Serializable {
	private String courseTitle;
	private String price;

	public void setCourseTitle(String courseTitle){
		this.courseTitle = courseTitle;
	}

	public String getCourseTitle(){
		return courseTitle;
	}

	public void setPrice(String price){
		this.price = price;
	}

	public String getPrice(){
		return price;
	}

	@Override
 	public String toString(){
		return 
			"WebAutomationPojo{" + 
			"courseTitle = '" + courseTitle + '\'' + 
			",price = '" + price + '\'' + 
			"}";
		}
}