package com.revature.caliber.assessment.beans;

/**
 * The type Note.
 */
public class Note {

    private int noteId;

    private String content;

    private String sugarCoatedContent;

    /**
     * Instantiates a new Note.
     *
     * @param content     the content
     * @param sugarCoated the sugar coated
     */
    public Note(String content, boolean sugarCoated) {
        super();
        if (sugarCoated)
            this.sugarCoatedContent = content;
        else
            this.content = content;
    }

    /**
     * Instantiates a new Note.
     */
    public Note() {
        super();
    }

    /**
     * Gets note id.
     *
     * @return the note id
     */
    public int getNoteId() {
        return noteId;
    }

    /**
     * Sets note id.
     *
     * @param noteId the note id
     */
    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    /**
     * Gets content.
     *
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets content.
     *
     * @param content the content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Gets sugar coated content.
     *
     * @return the sugar coated content
     */
    public String getSugarCoatedContent() {
        return sugarCoatedContent;
    }

    /**
     * Sets sugar coated content.
     *
     * @param sugarCoatedContent the sugar coated content
     */
    public void setSugarCoatedContent(String sugarCoatedContent) {
        this.sugarCoatedContent = sugarCoatedContent;
    }

    @Override
    public String toString() {
        return "Note{" +
                "noteId=" + noteId +
                ", content='" + content + '\'' +
                ", sugarCoatedContent='" + sugarCoatedContent + '\'' +
                '}';
    }
}
