#!usr/bin/python3

import sys

class ParticleChamber(object):

    def isNotValidParticle(self, pos):
        return (pos < 0 or pos > self.chamber_length - 1)

    def printParticleChamber(self):
        return("\n".join(self.chamber_states))

    def saveCurrentChamber(self):
        """ Print the current state of the chamber in the console """
        s_chamber = ["."] * self.chamber_length
        for x in self.l_particles:
            s_chamber[x] = 'X'

        for x in self.r_particles:
            s_chamber[x] = 'X'

        self.chamber_states.append(''.join(s_chamber))

    def animateChamber(self):
        """ Calcul the positions of the particules in the chamber for each iteration. Stop when there are no more particles in the chamber """
        particles_number = len(self.l_particles) + len(self.r_particles) #Initial value 
        while particles_number > 0:
            self.saveCurrentChamber()

            it = 0
            #Parse the table dynamically for L particles
            while it < len(self.l_particles):
                self.l_particles[it] -= self.speed
                if self.isNotValidParticle(self.l_particles[it]): #Delete the out of the bond particle from the list
                    del self.l_particles[it] 
                    particles_number = particles_number - 1
                    it -=1
                it += 1

            it = 0
            #Parse the table dynamically for R particles
            while it < len(self.r_particles):
                self.r_particles[it] += self.speed
                if self.isNotValidParticle(self.r_particles[it]): #Delete the out of the bond the particle from the list
                    del self.r_particles[it]
                    particles_number = particles_number - 1
                    it -=1
                it += 1
        self.saveCurrentChamber()

    """docstring for ParticleChamber"""
    def __init__(self, speed, init):
        self.speed = speed
        self.chamber_length = len(init)
        self.l_particles = []
        self.r_particles = []
        self.chamber_states = []

        for x in range(self.chamber_length):
            _p = init[x]
            if (_p == 'L'):
                self.l_particles.append(x)
            elif (_p == 'R'):
                self.r_particles.append(x)

def animate(speed, init):
    """   Animate a chamber with given speed and initial particle positions
    """
    particleChamber = ParticleChamber(speed, init)
    particleChamber.animateChamber()
    return particleChamber.printParticleChamber()

def main():
    """    Input parameters
    speed will be between 1 and 10 inclusive
    init will contain between 1 and 50 characters inclusive
    each character in init will be '.' or 'L' or 'R'
    """
    allowedInputChars = set('LR.')

    try:
        # User input for particles speed
        _speed = int(input("Speed of the particles (integer) : "))
        if _speed < 1 or _speed > 10:
            raise Exception("Speed must be a number between 1 and 10 inclusive")

        # User input for particles configuration
        _particles = input("Enter particles configuration (string) : ")
        if len(_particles) < 1 or len(_particles) > 50:
            raise Exception("Configuration size not allowed. Must contain between 1 and 50 characters inclusive. Current size : "+str(len(_particles)))
        elif not set(_particles).issubset(allowedInputChars):
            raise Exception("Some characters aren't allowed.")

    except Exception as e:
        sys.exit("Error : Configuration not recognized. "+str(e));

    print(animate(_speed, _particles))


if __name__ == "__main__":
    main()