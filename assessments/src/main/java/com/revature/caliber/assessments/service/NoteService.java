package com.revature.caliber.assessments.service;

import java.util.List;

import com.revature.caliber.assessments.beans.Note;

public interface NoteService {
	
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
