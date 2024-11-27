package Test;
import queue.CircularQueue;
import queue.LinkedQueue;
import queue.Queue;
import org.junit.jupiter.api.Test;
import queue.SimpleQueue;

import static org.junit.jupiter.api.Assertions.*;


public class QueueTest {
    @Test
    void testQueueOperations() {
        Queue<Integer> queue = new LinkedQueue<>();
        assertTrue(queue.isEmpty());

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(3, queue.size());
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.size());
        assertEquals(2, queue.dequeue());
        assertEquals(1, queue.size());
        assertEquals(3, queue.dequeue());
        assertTrue(queue.isEmpty());
    }
}
