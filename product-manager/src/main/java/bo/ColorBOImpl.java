package bo;

import dao.ColorDAO;
import dao.ColorDAOImpl;
import model.Color;

import java.util.List;

public class ColorBOImpl implements ColorBO {
    private ColorDAO colorDAO=new ColorDAOImpl();

    @Override
    public List<Color> listColor() {
        return this.colorDAO.listColor();
    }

    @Override
    public Color searchColorById(String id) {
        return this.searchColorById(id);
    }
}
