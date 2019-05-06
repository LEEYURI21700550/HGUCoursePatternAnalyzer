package edu.handong.analysis;

import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.datamodel.Student;

public class HGUCoursePatternAnalyzer {
	
	String[] lines = {	"1999-1, JC Nam, Java Programming",
						"1999-2, JC Nam, Programming Language Theory",
						"1999-1, JC Nam, Data Structures",
						"2001-1, JC Nam, Database Systems",
						"2018-1, SB Lim, Java Programming",
						"2018-2, SB Lim, Programming Language Theory",
						"2019-1, SB Lim, Data Structures",
						"2019-1, SB Lim, Algorithm Analysis",
						"2018-1, SJ Kim, Java Programming",
						"2018-2, SJ Kim, Programming Language Theory",
						"2019-1, SJ Kim, Logic Design",
						"2019-1, SJ Kim, Algorithm Analysis",
						};

	int numOfStudents;
	int numOfCourses;
	Student[] students;
	Course[] courses;
	
	/**
	 * This method runs our analysis logic to get the list of student and course names from lines.
	 * @param args
	 */
	public void run(String[] args) {
		
		numOfStudents = Integer.parseInt(args[0]);
		numOfCourses = Integer.parseInt(args[1]);
	
		students = initiateStudentArrayFromLines(lines);
		
		System.out.println("Number of All Students: " + numOfStudents);
		for(Student student: students) {
			System.out.println(student.getName());
		}
		
		courses = initiateCourseArrayFromLines(lines);
		System.out.println("Number of All Courses: " + numOfCourses);
		for(Course course: courses) {
			System.out.println(course.getCourseName());
		}
		
		
	}

	/**
	 * This method returns a Student array to initiate the field, students, from lines.
	 * @param lines
	 * @return
	 */
	private Student[] initiateStudentArrayFromLines(String[] lines) {
		Student[] students = new Student[3];
		String[] temp1;
		Student[] temp2 = new Student[lines.length];
		int i=0;
		int k=0;
		
		for(String line : lines)
		{
			temp1=line.split(",");
			
			temp2[i]=new Student(temp1[1].trim());
			i++;
		}
		
		i=0;

		if(students[1]==null && students[2]==null && students[0]==null)
		{
			students[0]=temp2[0];
			students[1]=temp2[0];
			students[2]=temp2[0];
		}
		
		for(k=0; k<temp2.length; k++)
		{
			if(studentExist(students,temp2[k])==false)
			{
				i++;
				students[i]=temp2[k];		
			}
			
		}
	return students;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, students
	 * @param students
	 * @param student
	 * @return boolean
	 */
	private boolean studentExist(Student[] students, Student student) {
		int i=0;
		
		for(i=0; i<3; i++)
		{
			if(students[i].getName().equals(student.getName()))
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return
	 */
	private Course[] initiateCourseArrayFromLines(String[] lines) {
		Course[] courses = new Course[6];
		String[] temp1;
		Course[] temp2 = new Course[lines.length];
		int i=0;
		int k=0;
		
		for(String line : lines)
		{
			temp1=line.split(",");
			
			temp2[i]=new Course(temp1[2].trim());
			i++;
		}
		
		i=0;
		
		for(i=0; i<6; i++)
		{
			courses[i]=temp2[0];
		}
		
		i=0;
		for(k=0; k<temp2.length; k++)
		{
			if(courseExist(courses,temp2[k])==false)
			{
				i++;
				courses[i]=temp2[k];
			}
			
		}
	return courses;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param courses
	 * @param course
	 * @return boolean
	 */
	private boolean courseExist(Course[] courses, Course course) {
		int i=0;
		
		for(i=0; i<6; i++)
		{
			if(courses[i].getCourseName().equals(course.getCourseName()))
			{
				return true;
			}
		}
		return false;
	}

	
	
}
