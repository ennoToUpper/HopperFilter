package ennotoupper.hopperfilter;

public enum FilterTypes {
        NORTH(0),
        NORTH_EAST(2),
        EAST(4),
        SOUTH_EAST(6),
        SOUTH(8),
        SOUTH_WEST(10),
        WEST(12),
        NORTH_WEST(14),
        None(255);

        private final int lvl;

        FilterTypes(int lvl) {
                this.lvl = lvl;
        }

        public int getLvl() {
                return lvl;
        }
}
