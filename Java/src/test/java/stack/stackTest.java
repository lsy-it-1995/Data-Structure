package stack;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

public class stackTest {
    private List<stack<Integer>> stacks = new ArrayList<>();

    @Before
    public void setup() {
        stacks.add(new listStack<Integer>());
        stacks.add(new arrayStack<Integer>());
        stacks.add(new intStack(2));
    }

    @Test
    public void testEmptyStack() {
        for (stack stack : stacks) {
            assertThat(stack.isEmpty()).isTrue();
            assertThat(stack.size()).isEqualTo(0);
        }
    }

    @Test(expected = Exception.class)
    public void testPopOnEmpty() {
        for (stack stack : stacks) {
            stack.pop();
        }
    }

    @Test(expected = Exception.class)
    public void testPeekOnEmpty() {
        for (stack stack : stacks) {
            stack.peek();
        }
    }

    @Test
    public void testPush() {
        for (stack<Integer> stack : stacks) {
            stack.push(2);
            assertThat(stack.size()).isEqualTo(1);
        }
    }

    @Test
    public void testPeek() {
        for (stack<Integer> stack : stacks) {
            stack.push(2);
            assertThat((int) (Integer) stack.peek()).isEqualTo(2);
            assertThat(stack.size()).isEqualTo(1);
        }
    }

    @Test
    public void testPop() {
        for (stack<Integer> stack : stacks) {
            stack.push(2);
            assertThat((int) stack.pop()).isEqualTo(2);
            assertThat(stack.size()).isEqualTo(0);
        }
    }

    @Test
    public void testExhaustively() {
        for (stack<Integer> stack : stacks) {
            assertThat(stack.isEmpty()).isTrue();
            stack.push(1);
            assertThat(stack.isEmpty()).isFalse();
            stack.push(2);
            assertThat(stack.size()).isEqualTo(2);
            assertThat((int) stack.peek()).isEqualTo(2);
            assertThat(stack.size()).isEqualTo(2);
            assertThat((int) stack.pop()).isEqualTo(2);
            assertThat(stack.size()).isEqualTo(1);
            assertThat((int) stack.peek()).isEqualTo(1);
            assertThat(stack.size()).isEqualTo(1);
            assertThat((int) stack.pop()).isEqualTo(1);
            assertThat(stack.size()).isEqualTo(0);
            assertThat(stack.isEmpty()).isTrue();
        }
    }
}
