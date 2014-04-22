package q2;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

public class ScoreCalculatorTest {

	@Test
	public void test() {
		ScoreCalculator scoreCalculator = new ScoreCalculator();
		
		List<Record> scores = new ArrayList<Record>();
		String student1 = "student1";
		
		for(int i = 0; i < 5; i++) {
			scores.add(new Record(student1, "test"+i, 50+i));
		}
		for(int i = 6; i < 30; i++) {
			scores.add(new Record(student1, "test"+i, 25));
		}

		String student2 = "student2";
		
		for(int i = 0; i < 5; i++) {
			scores.add(new Record(student2, "test"+i, 75+i));
		}
		for(int i = 6; i < 30; i++) {
			scores.add(new Record(student2, "test"+i, 13));
		}
		
		List<FinalScore> finalScores = scoreCalculator.calculateFinalScoreFromRecords(scores);
		
		assertEquals(2, finalScores.size());
		
		if(finalScores.get(0).getStudentId().equals(student1)) {
			assertEquals(new Double(52), new Double(finalScores.get(0).getScore()));
			assertEquals(new Double(77), new Double(finalScores.get(1).getScore()));						
		}
		else {
			assertEquals(new Double(77), new Double(finalScores.get(0).getScore()));
			assertEquals(new Double(52), new Double(finalScores.get(1).getScore()));						
		}
	}

}
