package seedu.address.model.flashcard;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Flashcard's question in the StudyBuddy app.
 * Guarantees: immutable; is valid as declared in {@link #isValidQuestion(String)}
 */
public class Question {

    public static final String MESSAGE_CONSTRAINTS =
            "Questions should not be blank! (Or contain only whitespaces)";

    /*
     * Regex for not only whitespaces.
     */
    public static final String VALIDATION_REGEX = "(?!^ +$)^.+$*";

    public final String fullQuestion;

    /**
     * Constructs a {@code Question}.
     *
     * @param question A valid question.
     */
    public Question(String question) {
        requireNonNull(question);
        checkArgument(isValidQuestion(question), MESSAGE_CONSTRAINTS);
        fullQuestion = question;
    }

    /**
     * Returns true if a given string is a valid question.
     */
    public static boolean isValidQuestion(String test) {
        return test.matches(VALIDATION_REGEX);
    }


    @Override
    public String toString() {
        return fullQuestion;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Question // instanceof handles nulls
                && fullQuestion.equals(((Question) other).fullQuestion)); // state check
    }

    @Override
    public int hashCode() {
        return fullQuestion.hashCode();
    }
}
