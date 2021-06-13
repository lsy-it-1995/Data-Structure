package queue;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

public class queueTest {
    private List<queue<Integer>> queues = new ArrayList<>();

    @Before
    public void setup() {
        queues.add(new arrayQueue<Integer>(2));
        queues.add(new linkedQueue<Integer>());
        queues.add(new intQueue(2));
    }

    @Test
    public void testEmptyQueue() {
        for (queue queue : queues) {
            assertThat(queue.isEmpty()).isTrue();
            assertThat(queue.size()).isEqualTo(0);
        }
    }

    @Test(expected = Exception.class)
    public void testPollOnEmpty() {
        for (queue queue : queues) {
            queue.poll();
        }
    }

    @Test(expected = Exception.class)
    public void testPeekOnEmpty() {
        for (queue queue : queues) {
            queue.peek();
        }
    }

    @Test
    public void testOffer() {
        for (queue<Integer> queue : queues) {
            queue.offer(2);
            assertThat(queue.size()).isEqualTo(1);
        }
    }

    @Test
    public void testPeek() {
        for (queue<Integer> queue : queues) {
            queue.offer(2);
            assertThat((int) queue.peek()).isEqualTo(2);
            assertThat(queue.size()).isEqualTo(1);
        }
    }

    @Test
    public void testPoll() {
        for (queue<Integer> queue : queues) {
            queue.offer(2);
            assertThat((int) queue.poll()).isEqualTo(2);
            assertThat(queue.size()).isEqualTo(0);
        }
    }

    @Test
    public void testExhaustively() {
        for (queue<Integer> queue : queues) {
            assertThat(queue.isEmpty()).isTrue();
            queue.offer(1);
            assertThat(queue.isEmpty()).isFalse();
            queue.offer(2);
            assertThat(queue.size()).isEqualTo(2);
            assertThat((int) queue.peek()).isEqualTo(1);
            assertThat(queue.size()).isEqualTo(2);
            assertThat((int) queue.poll()).isEqualTo(1);
            assertThat(queue.size()).isEqualTo(1);
            assertThat((int) queue.peek()).isEqualTo(2);
            assertThat(queue.size()).isEqualTo(1);
            assertThat((int) queue.poll()).isEqualTo(2);
            assertThat(queue.size()).isEqualTo(0);
            assertThat(queue.isEmpty()).isTrue();
        }
    }
}
