package Application;

class Player {
    private String _name;
    private int _score;
    private int _place;
    private boolean _victor;

    public Player(String name){
        _name = name;
        _score = 0;
        _victor = false;

    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public int get_score() {
        return _score;
    }

    public void set_score(int _score) {
        this._score = _score;
    }

    public int get_place() {
        return _place;
    }

    public void set_place(int _place) {
        this._place = _place;
    }

    public boolean is_victor() {
        return _victor;
    }

    public void set_victor(boolean _victor) {
        this._victor = _victor;
    }
}
