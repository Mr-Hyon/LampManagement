
public class MockClient extends Client {
    String name;
    boolean type;
    int yingshouedu;
    int yingshou;
    int yingfu;
    String businessman;
    public MockClient(String name){
    	this.name=name;
    }
    public String getname(){
    	return name;
    }
    
    public void MockClient0(boolean type){
    	this.type=type;
    }
    public boolean gettype(){
    	return type;
    }
    
    public void MockClient1(int yingshouedu){
    	this.yingshouedu=yingshouedu;
    }
    public int getyingshouedu(){
    	return yingshouedu;
    }
    
    public void MockClient2(int yingshou){
    	this.yingshou=yingshou;
    }
    public int getyingshou(){
    	return yingshou;
    }
    
    public void MockClient3(int yingfu){
    	this.yingfu=yingfu;
    }
    public int getyingfu(){
    	return yingfu;
    }
    
    public void MockClient4(String businessman){
    	this.businessman=businessman;
    }
    public String getbusinessman(){
    	return businessman;
    }
}
