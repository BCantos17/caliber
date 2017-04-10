package com.revature.caliber.assessments.data;

import java.util.List;

import com.revature.caliber.assessments.beans.Note;

/**
 * 
 * Note DAO interface for data tier
 *
 */
public interface NoteDAO {

	/**
	 * 
	 * Return a single note
	 * 
	 */
	public Note getNote(String note);
	
	/**
	 * 
	 * Return a list of all notes
	 * 
	 */
	public List<Note> getAllNotes();

}
