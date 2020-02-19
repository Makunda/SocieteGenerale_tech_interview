package com.soge.particlesChamber;

import com.soge.particlesChamber.model.ParticleChamber;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ParticlesChamberApplicationTests {

	public List<String> animate (int speed, String init) {
		ParticleChamber particleChamber = new ParticleChamber(speed, init);
		particleChamber.animateChamber();
		return particleChamber.printChamber();
	}

	@Test
	void BasicPattern() {
		int speed = 2;
		String init = "..R....";
		String result = "[..X...., ....X.., ......X, .......]" ; //animate(speed, init);
		assertEquals(result, Arrays.toString(animate(speed, init).toArray()) );
	}

	@Test
	void BigPattern() {
		int speed = 1;
		String init = "LRRL.LR.LRR.R.LRRL.";
		String result = "[XXXX.XX.XXX.X.XXXX., ..XXX..X..XX.X..XX., .X.XX.X.X..XX.XX.XX, X.X.XX...X.XXXXX..X, .X..XXX...X..XX.X.., X..X..XX.X.XX.XX.X., ..X....XX..XX..XX.X, .X.....XXXX..X..XX., X.....X..XX...X..XX, .....X..X.XX...X..X, ....X..X...XX...X.., ...X..X.....XX...X., ..X..X.......XX...X, .X..X.........XX..., X..X...........XX.., ..X.............XX., .X...............XX, X.................X, ...................]";
		assertEquals(result, Arrays.toString(animate(speed, init).toArray()) );
	}

	@Test
	void ReallyFastPattern() {
		int speed = 10;
		String init = "RLRLRLRLRL";
		String result = "[XXXXXXXXXX, ..........]" ; //animate(speed, init);
		assertEquals(result, Arrays.toString(animate(speed, init).toArray()) );
	}

	@Test
	void NearlyEmptyPattern() {
		int speed = 1;
		String init = "R";
		String result = "[X, .]" ; //animate(speed, init);
		assertEquals(result, Arrays.toString(animate(speed, init).toArray()) );
	}

}
