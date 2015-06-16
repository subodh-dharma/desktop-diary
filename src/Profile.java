import java.io.Serializable;

/*
 * Class : Profile
 * Description : A serialized class which contains the information of the user to be stored.
 * 				It contains the getter and setter methods for the fields in the profile.
 * */
class Profile implements Serializable
{
	private String name,age,dob,mailid,contact,password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getMailid() {
		return mailid;
	}

	public void setMailid(String mailid) {
		this.mailid = mailid;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
}
