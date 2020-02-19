package com.soge.particlesChamber.model;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParticleChamber {
    int speed;
    int chamberSize;
    List<String> states;
    List<int[]> particles;

    public List<String> printChamber() {
        return this.states;
    }

    private void saveState() {
        char[] s = new char[this.chamberSize];
        Arrays.fill(s,'.');
        for (int[] row : this.particles) {
            s[row[1]] = 'X';
        }
        this.states.add(new String(s));
    }

    public void animateChamber() {
        while (this.particles.size() > 0) {
            this.saveState();
            for (int i = 0; i < this.particles.size(); i++) {
                int[] p = this.particles.get(i);
                if (p[0] == 1) {
                    p[1] += this.speed;
                } else {
                    p[1] -= this.speed;
                }
                if(p[1] < 0 || p[1] > this.chamberSize -1) {
                    this.particles.remove(i);
                    i -= 1;
                }
                else this.particles.set(i, p);

            }
        }
        this.saveState();
    }

    public ParticleChamber(int speed,String config) {
        this.particles = new ArrayList<int[]>();
        this.states = new ArrayList<String>();
        this.speed = speed;
        this.chamberSize = config.length();
        for (int i = 0; i < config.length(); i++) {
            char c = config.charAt(i);
            if (c == 'L') this.particles.add(new int[] {-1, i});
            if (c == 'R') this.particles.add(new int[] {1, i});
        }
    }

}
