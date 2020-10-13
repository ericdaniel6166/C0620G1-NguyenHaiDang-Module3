package dao;

import model.Color;

import java.util.List;

public interface ColorDAO {
    List<Color> listColor();

    Color searchColorById(String id);
}
