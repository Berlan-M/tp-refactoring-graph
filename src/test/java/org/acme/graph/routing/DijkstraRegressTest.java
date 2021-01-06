package org.acme.graph.routing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.acme.graph.TestGraphFactory;
import org.acme.graph.model.Edge;
import org.acme.graph.model.Graph;
import org.acme.graph.model.Path;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests fonctionnels sur DijkstraPathFinder
 * 
 * @author MBorne
 *
 */
public class DijkstraRegressTest {

	private Graph graph;

	private DijkstraPathFinder finder;

	@Before
	public void setUp() throws Exception {
		this.graph = TestGraphFactory.createGraph01();
		this.finder = new DijkstraPathFinder(graph);
	}

	@Test
	public void testAbFind() {
		Path path1 = finder.findPath(graph.findVertex("a"), graph.findVertex("b"));
		assertNotNull(path1);
		assertEquals(1, path1.getPathSize());
	}

	@Test
	public void testbaNotFound() {
		Path path2 = finder.findPath(graph.findVertex("b"), graph.findVertex("a"));
		assertEquals(0, path2.getPathSize());
	}

	
}