package interview;

import java.util.Stack;

public class AsteroidsCollision {

    // O(N) time, O(N) space
    // Stack approach
    // https://leetcode.com/problems/asteroid-collision/

    public static int[] asteroidCollision(int[] asteroids) {

        if (asteroids == null || asteroids.length <= 1) return asteroids;

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < asteroids.length; ++i) {

            if (st.isEmpty())
                st.push(asteroids[i]);
            else {

                if (sign(st.peek()) == 1 && sign(asteroids[i]) == -1)
                {

                    int absA = Math.abs(st.peek());
                    int absB = Math.abs(asteroids[i]);
                    if (absA < absB){
                        st.pop();
                        if (!st.isEmpty() && sign(st.peek()) != sign(asteroids[i]))
                            i--;
                        else st.push(asteroids[i]);
                    }
                    else if (absA == absB) {
                        st.pop();
                    }

                }
                else st.push(asteroids[i]);

            }
        }

        int[] sol = new int[st.size()];
        for (int i = sol.length - 1; i >= 0; --i)
            sol[i] = st.pop();

        return sol;

    }

    /**
     * Additional method that returns the sign of an integer value
     * @param x integer value we are interested in its sign
     * @return 1: if x greater or equal to 0 or 0 otherwise
     */
    public static int sign (int x) {
        if (x == Math.abs(x)) return 1;
        else return -1;
    }
}
