public interface Exceptions{
	private String message;
	public NullPointerException(String message){
		super("NullPointer");
	}
	public String getMessage(){
		System.out.println(message);
	}
} 