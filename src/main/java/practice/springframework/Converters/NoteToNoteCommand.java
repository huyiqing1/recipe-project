package practice.springframework.Converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import practice.springframework.Commands.NoteCommand;
import practice.springframework.Models.Note;

@Component
public class NoteToNoteCommand implements Converter<Note, NoteCommand> {

    @Synchronized
    @Nullable
    @Override
    public NoteCommand convert(Note source) {
        if (source == null)
            return null;
        final NoteCommand noteCommand = new NoteCommand();
        noteCommand.setId(source.getId());
        noteCommand.setRecipeNotes(source.getRecipeNote());
        return noteCommand;
    }
}
