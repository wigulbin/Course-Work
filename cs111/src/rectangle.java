
public class rectangle {

	//instance fields
	private int height;
	private int width;
	
	//default values
	public static final int DEFAULT_WIDTH = 3;
	public static final int DEFAULT_HEIGHT = 5;
	
	//constructor
	public rectangle(){
		width = DEFAULT_WIDTH;
		height = DEFAULT_HEIGHT;
	}
	public rectangle(int height, int width){
		this.height=height;
		this.width=width;
	}
	
	//getter
	public int getHeight(){
		return height;
	}
	public int getWidth(){
		return width;
	}
	
	//setter
	public void setWidth(int w){
		width=w;
	}
	public void setHeigth(int h){
		height=h;
	}
	
	
	public int area(){
		return height*width;
	}
	public int perimeter(){
		return (height*2)+(width*2);
	}
	
	public void changeHeight(int factor){
		height+=factor;
	}
	public void changeWidth(int factor){
		width+=factor;
	}

	public void scale(int factor){
		width *= factor;
		height *= factor;
	}
	
	public String toString(){
		return "height= " + height + "  width = "+width; 
	}
}
