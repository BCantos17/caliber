package com.revature.caliber.assessments.service.implementations;

import java.util.List;

import com.revature.caliber.assessments.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.caliber.assessments.beans.Note;
import com.revature.caliber.assessments.data.Facade;
import com.revature.caliber.assessments.service.NoteService;

@Service(value="noteService")
public class NoteServiceImpl implements NoteService{

	private Facade facade;

    @Autowired
    public void setFacade(Facade facade) {
        this.facade = facade;
    }
    
    public Note getNote(String note){return facade.getNote(note);}
    
    public List<Note> getAllNotes(){return facade.getAllNotes();}
}
