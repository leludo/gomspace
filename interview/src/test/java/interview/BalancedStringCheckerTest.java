package interview;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BalancedStringCheckerTest {

	@DisplayName("BalancedStringChecker.isBalanced() checks with balanced strings")
	@ParameterizedTest
	@ValueSource(strings = { "", "  ", "{}", "{[()]}", "{ [(   )   ] }" })
	void testBalancedStringChecker_balancedStrings(String input) {
		assertTrue(BalancedStringChecker.isBalanced(input));

	}

	@DisplayName("BalancedStringChecker.isBalanced() checks with unbalanced strings")
	@ParameterizedTest
	@ValueSource(strings = { "{", " { ", "{}]", "{[([)]}", "{ [(   )   ]" })
	void testBalancedStringChecker_unBalancedStrings(String input) {
		assertFalse(BalancedStringChecker.isBalanced(input));

	}

}
