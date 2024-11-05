package cg.products.productrest.dto;

public class ProductResponseDto {

		long pid;
		String name;
		int price;
		String category;
		public long getPid() {
			return pid;
		}
		public void setPid(long pid) {
			this.pid = pid;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		
		
}
