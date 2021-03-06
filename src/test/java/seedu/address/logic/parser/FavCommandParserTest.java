//@@author siri99
package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_PERSON;
import static seedu.address.testutil.TypicalIndexes.INDEX_THIRD_PERSON;

import org.junit.Test;

import seedu.address.logic.commands.FavCommand;

/**
 * As we are only doing white-box testing, our test cases do not cover path variations
 * outside of the FavCommand code. For example, inputs "1" and "1 abc" take the
 * same path through the FavCommand, and therefore we test only one of them.
 * The path variation for those two cases occur inside the ParserUtil, and
 * therefore should be covered by the ParserUtilTest.
 */
public class FavCommandParserTest {

    private FavCommandParser parser = new FavCommandParser();

    @Test
    public void parse_validArgs_returnsFavCommand() {
        assertParseSuccess(parser, "1", new FavCommand(INDEX_FIRST_PERSON));
        assertParseSuccess(parser, "2", new FavCommand(INDEX_SECOND_PERSON));
        assertParseSuccess(parser, "3", new FavCommand(INDEX_THIRD_PERSON));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {

        // Fails when user attempts to add a person into favourite list by character
        assertParseFailure(parser, "a", String.format(MESSAGE_INVALID_COMMAND_FORMAT, FavCommand.MESSAGE_USAGE));

        // Fails when user attempts to add a person into favourite list by name
        assertParseFailure(parser, "Alice", String.format(MESSAGE_INVALID_COMMAND_FORMAT, FavCommand.MESSAGE_USAGE));
    }
}
//@@author siri99
