package edu.mum.framework.domain;

import java.io.Serializable;

public abstract class AProduct implements Serializable{
		   
	private static final long serialVersionUID = 1L;
	       private String productName;
		   private String productId;
		   private String productDesc;
		   private boolean status; 
		   private double unitPrice;
		   private String category;
		   private Unit unit;
		   
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public double getUnitPrice() {
			return unitPrice;
		}
		public void setUnitPrice(double unitPrice) {
			this.unitPrice = unitPrice;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public Unit getUnit() {
			return unit;
		}
		public void setUnit(Unit unit) {
			this.unit = unit;
		}
		public AProduct(String productName, String productId, String productDesc, boolean status, double unitPrice,
				String category, Unit unit) {
			this.productName = productName;
			this.productId = productId;
			this.productDesc = productDesc;
			this.status = status;
			this.unitPrice = unitPrice;
			this.category = category;
			this.unit = unit;
		}
		
		public String getProdcutName() {
			return productName;
		}
		public void setProdcutName(String productName) {
			this.productName = productName;
		}
		public String getProductId() {
			return productId;
		}
		public void setProductId(String productId) {
			this.productId = productId;
		}
		
		public String getProductDesc() {
			return productDesc;
		}

      public void setProductDesc(String productDesc) {
			this.productDesc = productDesc;
		}



		public boolean isStatus() {
			return status;
		}



		public void setStatus(boolean status) {
			this.status = status;
		}
		@Override
		public String toString() {
			return "Product [productName=" + productName + ", productId=" + productId + ", productDesc=" + productDesc
					+ ", status=" + status + ", unitPrice=" + unitPrice + ", category=" + category + ", unit=" + unit
					+ "]";
		}
		
		
		      
}
