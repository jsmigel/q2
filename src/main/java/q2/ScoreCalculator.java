package q2;

import java.util.*;

public class ScoreCalculator {
	
	private static final int MAX = 5;

	/*
	 * This is O(N) by number of records.  We will iterate over the list exactly once, and store
	 * the top 5 scores for each student.
	 * 
	 * Memory requirements are O(N) by number of students.
	 */
	List<FinalScore> calculateFinalScoreFromRecords(List<Record> records) {
		// Store a list of top scores for each student
		Map<String, List<Record>> studentTopScores = new HashMap<String, List<Record>>();
		
		// Process each record
		for(Record record : records) {
			String studentId = record.getStudentId();
			
			if(!studentTopScores.containsKey(studentId)) {
				studentTopScores.put(studentId, new ArrayList<Record>());
			}
			
			// For easier readability, get the list of top scores for this student
			List<Record> topScores = studentTopScores.get(studentId);
			
			// As long as we do not have MAX top scores, just add this one.
			if(topScores.size()<MAX) {
				topScores.add(record);
			} else {
				// At this point, we know they have MAX scores in the list.  Look for the lowest score in that list.
				// Note - there is a performance hit here for larger values of MAX.  Since this is currently set to
				// 5, this is negligible.
				Record lowestScore = null;
				// Search each of the student's top scores for the lowest
				for(Record score : topScores) {
					if(lowestScore == null) {
						lowestScore = score;
					}
					else {
						if(score.getTestScore() < lowestScore.getTestScore()) {
							lowestScore = score;
						}
					}
				}
				
				// If the current score is lower, then replace it
				if(record.getTestScore() > lowestScore.getTestScore()) {
					topScores.remove(lowestScore);
					topScores.add(record);
				}
			}
		}
		
		// Now figure out final scores
		List<FinalScore> finalScores = new ArrayList<FinalScore>();
		
		// Average all of the top scores.  Again, for small values of MAX the performance hit is small.
		for(String studentId : studentTopScores.keySet()) {
			double finalScore = 0;
			
			System.out.println(studentId+" has "+studentTopScores.get(studentId).size());
			
			for(Record record : studentTopScores.get(studentId)) {
				finalScore += record.getTestScore();
			}
			
			finalScore /= studentTopScores.get(studentId).size();
			
			finalScores.add(new FinalScore(studentId, finalScore));
		}
		
		return finalScores;
	}

}
