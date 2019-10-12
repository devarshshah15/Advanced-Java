public class Car implements java.io.Serializable {   
   private int id, year, price, num;   
   private String name, comp_name;
   private float rating;    
  
   public int getId() { 
      return id; 
   } 
   public String getName() { 
      return name; 
   } 
   public String getCompName() { 
      return comp_name; 
   } 
   public int getYear() { 
      return year; 
   } 
   public int getPrice() { 
      return price; 
   }
   public int getNum() { 
      return num; 
   }
   public float getRating() {
      return rating;
   } 
   public void setID(int id) { 
      this.id = id; 
   } 
   public void setName(String name) { 
      this.name = name; 
   } 
   public void setCompName(String comp_name) { 
      this.comp_name = comp_name; 
   } 
   public void setYear(int year) { 
      this.year = year; 
   } 
   public void setPrice(int price) { 
      this.price = price; 
   }
   public void setNum(int num) { 
      this.num = num; 
   }
   public void setRating(float rating) { 
      this.rating = rating; 
   } 
}