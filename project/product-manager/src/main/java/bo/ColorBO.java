package bo;

import model.Color;

import java.util.List;

public interface ColorBO {
    List<Color> listColor();

    Color searchColorById(String id);
}
