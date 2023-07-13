package org.example;
public class Goods {
    private String goodsId;
    private String name;
    private double price;
    //public Goods(){};
 
    public Goods(String goodsId, String name, double price) {
        this.goodsId = goodsId;
        this.name = name;
        this.price = price;
        
    }
 
    @Override
	public String toString() {
		return  goodsId +","+name + "," + price ;
	}
 
	public String getGoodsId() {
        return goodsId;
    }
 
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public double getPrice() {
        return price;
    }
 
    public void setPrice(double price) {
        this.price = price;
    }
 
 
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((goodsId == null) ? 0 : goodsId.hashCode());
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Goods other = (Goods) obj;
        if (goodsId == null) {
            if (other.goodsId != null)
                return false;
        } else if (!goodsId.equals(other.goodsId))
            return false;
        return true;
    }
}