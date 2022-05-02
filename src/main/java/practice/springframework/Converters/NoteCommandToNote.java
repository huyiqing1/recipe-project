package practice.springframework.Converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import practice.springframework.Commands.NoteCommand;
import practice.springframework.Models.Note;

@Component
public class NoteCommandToNote implements Converter<NoteCommand, Note> {

    @Synchronized
    @Nullable
    @Override
    public Note convert(NoteCommand source) {
        if (source == null)
            return null;
        final Note note = new Note();
        note.setId(source.getId());
        note.setRecipeNote(source.getRecipeNotes());
        return note;
    }
}
