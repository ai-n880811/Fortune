package Bean;

public class Fortune {
    private String result;
    private String message;
	private String color;

    public Fortune(String result, String message, String color) {
        this.result = result;
        this.message = message;
        this.color = color;
    }

    public String getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }
    public String getColor() {
    	return color; 
    }
}
