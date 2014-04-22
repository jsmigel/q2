package q2;

public class Record {
	private String studentId;
	private String testId;
	private double testScore;

	public Record(String studentId, String testId, double testScore) {
		this.studentId = studentId;
		this.testId = testId;
		this.testScore = testScore;
	}
	
	public String getStudentId() {
		return studentId;
	}
	public String getTestId() {
		return testId;
	}
	public double getTestScore() {
		return testScore;
	}

}
