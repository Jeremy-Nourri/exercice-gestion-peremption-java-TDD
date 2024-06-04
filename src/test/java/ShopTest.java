import org.example.entity.Product;
import org.example.entity.Shop;
import org.example.exception.NegativeValueException;
import org.example.exception.ValueGreaterThan50Exception;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ShopTest {

    private Shop shop;

    @Before
    public void setup() {
        shop = new Shop();
    }

    @Test
    public void ShouldDecreaseQualityTwiceFast_WhenTheExpirationDateValueIs0() {

        // Arrange
        Product product = new Product("normal", "product", 0, 10);
        Product productExpected = new Product("normal", "product", 0, 8);

        // Act
        shop.update(product);

        // Assert
        Assert.assertEquals(productExpected, product);

    }

    @Test
    public void ShouldReturnException_WhenTheQualityValueIsNegative() {

        // Arrange
        Product product = new Product("normal", "product", 2, -1);

        // Assert
        Assert.assertThrows(NegativeValueException.class, () -> {
            shop.update(product);
        });

    }

    @Test
    public void ShouldReturnException_WhenTheQualityIsGreaterThan50() {

        // Arrange
        Product product = new Product("normal", "product", 2, 51);

        //Assert
        Assert.assertThrows(ValueGreaterThan50Exception.class, () -> {
            shop.update(product);
        });

    }

    @Test
    public void ShouldIncreaseQualityOfProductBrieVieilli_WhenSellInDaysIsDecreasing() {

        //Arrange
        Product product = new Product("laitiers", "brie vieilli", 10, 40);
        Product productExpected = new Product("laitiers", "brie vieilli", 9, 41);

        //Act
        shop.update(product);

        //Assert
        Assert.assertEquals(productExpected, product);

    }

    @Test
    public void ShouldDecreaseQualityTwiceAsFast_WhenTheValueOfAttributeTypeIsLaitier() {
        //Arrange
        Product product = new Product("laitier", "lait", 10, 40);
        Product productExpected = new Product("laitier", "lait", 9, 38);

        //Act
        shop.update(product);

        //Assert
        Assert.assertEquals(productExpected, product);

    }

}
