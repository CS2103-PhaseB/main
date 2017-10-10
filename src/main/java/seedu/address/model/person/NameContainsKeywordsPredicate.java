package seedu.address.model.person;

import java.util.*;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;
import seedu.address.model.tag.Tag;

/**
 * Tests that a {@code ReadOnlyPerson}'s {@code Name} matches any of the keywords given.
 */
public class NameContainsKeywordsPredicate implements Predicate<ReadOnlyPerson> {
    private final List<String> keywords;

    public NameContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(ReadOnlyPerson person) {
        Set<String> s1 = new HashSet<String>(keywords);
        String[] tagList=person.getOnlyTags().split(" ");
        Set<String> s2 = new HashSet<String>(Arrays.asList(tagList));

      return((keywords.stream()
              .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(person.getName().fullName, keyword)))||(!Collections.disjoint(s2, s1)));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof NameContainsKeywordsPredicate // instanceof handles nulls
                && this.keywords.equals(((NameContainsKeywordsPredicate) other).keywords)); // state check
    }

}
