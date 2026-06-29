package exercises.streamApi;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Создайте класс CelestialBody - небесное тело
 * Поля класса:
 * private String bodyDesignation; // Название небесного тела (Sun, Earth, Vesta)
 * private double bodyDensity;  // Плотность небесного тела (грамм на кубический сантиметр)
 * private BigDecimal bodyVolume; // Объем небесного тела (в киллометрах кубических)
 * @Setter(AccessLevel.NONE)
 * private BigInteger bodyMass; // Масса небесного тела (в кг)
 *
 * Методы класса:
 * public BigInteger getBodyMass() {
 *     // Считает и возвращает массу небесного тела (объем * плотность)
 * }
 *
 * Проинициализируйте список трех или более небесных тел List<CelestialBody>
 * Используя stream посчитайте массы этих объектов, соберите результат в карту Map<String, BigInteger>
 *
 * Пример вывода результирующей карты:
 * {"Earth"=5972200000000000000000000,
 * "Moon"=73460000000000000000000,
 * "Vesta"=259076000000000000000}
 */
public class CelestialBody {
    private String bodyDesignation;
    private double bodyDensity;
    private BigDecimal bodyVolume;
    private BigInteger bodyMass;

    public CelestialBody(String bodyDesignation, double bodyDensity, BigDecimal bodyVolume) {
        this.bodyDesignation = bodyDesignation;
        this.bodyDensity = bodyDensity;
        this.bodyVolume = bodyVolume;
        this.bodyMass = null;
    }

    public String getBodyDesignation() {
        return bodyDesignation;
    }

    public double getBodyDensity() {
        return bodyDensity;
    }

    public BigDecimal getBodyVolume() {
        return bodyVolume;
    }

    public BigInteger getBodyMass() {
        if (bodyMass == null) {
            BigDecimal densityConversion = new BigDecimal("1000000000000");
            BigDecimal densityInKgPerKm3 = BigDecimal.valueOf(bodyDensity)
                    .multiply(densityConversion);

            BigDecimal massBigDecimal = bodyVolume.multiply(densityInKgPerKm3);

            bodyMass = massBigDecimal.setScale(0, RoundingMode.HALF_UP).toBigInteger();
        }
        return bodyMass;
    }

    private void setBodyMass(BigInteger bodyMass) {
        this.bodyMass = bodyMass;
    }

    @Override
    public String toString() {
        return String.format("CelestialBody{designation='%s', density=%.3f, volume=%s, mass=%s}",
                bodyDesignation, bodyDensity, bodyVolume, getBodyMass());
    }

    public static void main(String[] args) {
        List<CelestialBody> celestialBodies = Arrays.asList(
                new CelestialBody("Earth", 5.513, new BigDecimal("1083210000000")),
                new CelestialBody("Moon", 3.344, new BigDecimal("21958000000")),
                new CelestialBody("Vesta", 3.456, new BigDecimal("74910000")),
                new CelestialBody("Mars", 3.934, new BigDecimal("163180000000")),
                new CelestialBody("Venus", 5.243, new BigDecimal("928430000000")),
                new CelestialBody("Mercury", 5.427, new BigDecimal("60830000000"))
        );

        System.out.println("\nInformation about celestial bodies: \n");
        for (CelestialBody body : celestialBodies) {
            System.out.println(body);
        }

        Map<String, BigInteger> massMap = celestialBodies.stream()
                .collect(Collectors.toMap(
                        CelestialBody::getBodyDesignation,
                        CelestialBody::getBodyMass
                ));

        System.out.println("\n=== Mass map ===\n");
        massMap.forEach((name, mass) ->
                System.out.println("\"" + name + "\" = " + mass)
        );
    }
}