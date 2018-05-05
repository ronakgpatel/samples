package samples.designpatterns.builder;

public class Item {
	private String category;
	private String parentCategory;
	public long price;
	private double discount;

	Item() {
	}

	public Item(String category, String parentCategory) {
		this.category = category;
		this.parentCategory = parentCategory;
	}

	public Item(String category) {
		this(category, null);
	}

	public Item(String category, String parentCategory, long price, double discount) {
		super();
		this.category = category;
		this.parentCategory = parentCategory;
		this.price = price;
		this.discount = discount;
	}

	public Item(String category, long price, double discount) {
		super();
		this.category = category;
		this.price = price;
		this.discount = discount;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(String parentCategory) {
		this.parentCategory = parentCategory;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public static Builder builder() {
		return new Builder();
	}

	@SuppressWarnings("all")
	public static void main(String[] args) {

		// Sample creating objects
		Item smartphone = Item.builder().category("smartphone").parentCategory("mobiles").build();
		Item tablets = Item.builder().category("tablets").build();
		Item laptops = Item.builder().category("laptops").price(32000l).discount(10.0d).build();
		Item battery = Item.builder().category("batteries").parentCategory("laptop_accessories").price(32000l)
				.discount(10.0d).build();
	}

	public static class Builder {
		private String category;
		private String parentCategory;
		public long price;
		private double discount;

		public Builder category(String cat) {
			this.category = cat;
			return this;
		}

		public Builder parentCategory(String pCat) {
			this.parentCategory = pCat;
			return this;
		}

		public Builder price(long p) {
			this.price = p;
			return this;
		}

		public Builder discount(double d) {
			this.discount = d;
			return this;
		}

		public Item build() {
			return new Item(category, parentCategory, price, discount);// or you can use setter methods
		}
	}

}