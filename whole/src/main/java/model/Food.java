package model;

import java.sql.Date;

public class Food extends Post {
	
	private String food_type;
	private Date exp_date;
	
	public Food()
	{
		super();
	}
	
	public Food(long post_id, String title, String type, String content, String image,
			Date reg_date, Long writer_id, String food_type, Date exp_date) {
		
		super(post_id, title, type, content, image, reg_date, writer_id);
		
		this.food_type = food_type;
		this.exp_date = exp_date;
	}

	public String getFood_type() {
		return food_type;
	}

	public void setFood_type(String food_type) {
		this.food_type = food_type;
	}

	public Date getExp_date() {
		return exp_date;
	}

	public void setExp_date(Date exp_date) {
		this.exp_date = exp_date;
	}
}
