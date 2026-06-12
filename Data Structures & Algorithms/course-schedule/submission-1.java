class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        /* map {
            course1 -> [prerequisites]
            course2 -> [prerequisites]
            ...
        }
        */

        /*
        loop through courses
        check if possible recursively. every iteration
          mark course as traversed
          check prerequisites
             mark prerequisites as traversed
             check prerequisites of prerequisites
               ...
               if current course was traversed already, return false
               if there are no prerequisites, return true
        */

        /* build map of prerequisites */
        Map<Integer, List<Integer>> prerequisitesMap = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int coursePrerequisite = prerequisite[1];
            
            List<Integer> currentPrerequisites = prerequisitesMap.getOrDefault(course, new ArrayList<>());
            currentPrerequisites.add(coursePrerequisite);
            prerequisitesMap.put(course, currentPrerequisites);
        }

        for (Integer course : prerequisitesMap.keySet()) {
            boolean isPossible = checkPossiblePrerequisite(course, new HashSet<>(), prerequisitesMap);
            if (!isPossible) return false;
        }
        return true;
    }

    public boolean checkPossiblePrerequisite(Integer course, Set<Integer> traversedCourses, Map<Integer, List<Integer>> prerequisitesMap) {
        if (traversedCourses.contains(course)) return false;
        
        traversedCourses.add(course);
        List<Integer> coursePrerequisites = prerequisitesMap.getOrDefault(course, new ArrayList<>());
        for (Integer prerequisite : coursePrerequisites) {
            if (!checkPossiblePrerequisite(prerequisite, traversedCourses, prerequisitesMap)) {
                return false;
            }
        }
        traversedCourses.remove(course);
        return true;
    }
}
