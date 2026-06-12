class Solution {
    record Coords(int x, int y) {}

    public static class Path {
        private List<Coords> coordsList = new ArrayList<>();
        private Set<Coords> coordsSet = new HashSet<>();
        public void addCoords(Coords c) {
            coordsList.add(c);
            coordsSet.add(c);
        }
        public boolean hasCoords(Coords c) {
            return coordsList.contains(c);
        }
        public Coords getLastCoords() {
            if (coordsList.isEmpty()) return null;
            return coordsList.get(coordsList.size() - 1);
        }
        public void removeLastCoords() {
            Coords coords = coordsList.get(coordsList.size() - 1);
            coordsList.remove(coordsList.size() - 1);
            coordsSet.remove(coords);
        }
    }

    public boolean exist(char[][] board, String word) {
        // board[0] -> first row
        // board[1] -> second row
        // ...
        
        char wordChar = word.charAt(0);
        String wordWithoutChar = word.substring(1);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char boardChar = board[i][j];
                if (boardChar == wordChar) {
                    Coords point = new Coords(i, j);
                    Path path = new Path();
                    path.addCoords(point);
                    boolean wordWasFound = findWord(board, wordWithoutChar, path);
                    if(wordWasFound) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean findWord(char[][] board, String word, Path path) {
        if (word.isEmpty()) return true;

        Coords startingPoint = path.getLastCoords();
        char nextChar = word.charAt(0);
        String nextWord = word.substring(1);
        List<Coords> candidateCoords = List.of(
            new Coords(startingPoint.x + 1, startingPoint.y),
            new Coords(startingPoint.x - 1, startingPoint.y),
            new Coords(startingPoint.x, startingPoint.y + 1),
            new Coords(startingPoint.x, startingPoint.y - 1)
        );
        for (Coords candidate : candidateCoords) {
            if (candidate.x >= 0 && candidate.x < board.length
                    && candidate.y >= 0 && candidate.y < board[0].length
                    && !path.hasCoords(candidate)
                    && board[candidate.x][candidate.y] == nextChar) {
                path.addCoords(candidate);
                boolean wordWasFound = findWord(board, nextWord, path);
                if (wordWasFound) return true;
                path.removeLastCoords();
            }
        }
        return false;
    }

    // word: CAT
    // search starting points: [0, 2], [2, 1]
    
    // word: AT
    // path: [[0,2]]
    // search [x-1, y], [x+1, y], [x, y+1], [x, y-1]
    //   points must be in the grid
    //   points must not be in the path

    
}
