package tamer.han15;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

public class ModelData {

    private final double[] xArray;
    private final RealVector x;
    private final double[] yArray;
    private final RealVector y;
    private final double[][] ZArray;
    private final RealMatrix Z;

    public ModelData() {

        xArray = new double[]{
            38.61396233, 36.52665184, 31.37096191, 26.04760884, 22.04267686, 20.01572667, 19.32403149, 19.1240658, 18.85824872,
            17.29959392, 15.82600632, 17.12326364, 18.00565018, 15.53059443, 13.52201262, 11.34727847, 11.24074448, 8.90987376,
            7.81959081, 6.85794111, 5.94864972, 7.17472148, 8.48831732, 9.33024861, 13.84075367, 15.24592162, 13.61403077,
            13.08625319, 12.64105085, 12.85534681, 12.81461328, 11.35948466, 12.03597037, 11.17179103, 10.00667407, 8.60318107,
            7.41483999, 6.56420378, 5.27884853, 3.87358333, 2.33867646, 0.62515168, 0.41392018, 0.00278786, 0.00282053,
            0.0230793, 0.21481325, 0.66039374, 0.21656629, 0.33659459, 0.82893175, 1.26257664, 2.11244658, 1.38826346,
            0.8655056, 0.76226485, 1.6245412, 1.96020259, 2.62757745, 2.47862397, 2.52980726, 2.17760992, 1.82326578,
            1.14788648, 0.90322225, 0.79732015, 0.69323265, 1.10893533, 1.33554424, 1.49062731, 1.96914943, 9.0531332,
            14.69517242, 19.19433796, 27.13206346, 30.84801083, 32.11182379, 32.04524971, 32.97391355, 32.05003137, 31.00410188,
            27.37850946, 25.53694849, 26.55295364, 27.35642809, 26.23820779, 25.88381916, 26.923698, 25.10221669, 20.38860933,
            17.83632388, 15.723877, 15.31846933, 15.51295698, 16.0686627, 14.54969683, 12.65345491, 12.17884162, 11.64786275,
            10.2790742, 10.03893891, 9.68575698, 10.03886809, 11.57626693, 10.74436528, 11.41832467, 11.22020164, 9.92559114,
            10.21501183, 10.37359753, 9.61133154, 8.95688982, 8.50372503, 8.80935247, 7.89796897, 7.53923174, 7.24834236, 8.72693113,
            8.19734857, 7.94211329, 8.06297553, 7.66944886, 7.45832459, 7.97945005, 7.90216246, 7.27670214, 9.57750466,
            19.25087258, 34.98208188, 29.35798236, 32.57805782, 31.28526118, 26.17061752, 24.45433025, 22.64480562, 20.27163706,
            19.38419574, 18.074223, 16.3427495, 17.74705025, 21.96245947, 33.19761916, 39.96218539, 40.9896082, 39.15537875,
            40.30852446, 39.63505303, 43.1646229, 43.86066422, 42.37429096, 38.64360184, 44.73282589, 68.82985414, 91.44831084,
            116.0009809, 121.25206983, 105.81170959, 93.7540864, 94.59968558, 87.62592862, 75.22015232, 72.31514898, 70.14792028,
            71.30904288, 66.16209858, 62.35729622, 58.66995704, 59.14880517, 56.19935, 54.3941415, 53.0416554, 50.91357738,
            49.50787196, 46.97301074, 44.12097052, 40.6128079, 39.19040579, 38.20382572, 35.93257353, 35.72365472, 35.33277817,
            34.51494151, 33.143428, 31.68121479, 32.55718386, 34.00378165, 34.42392, 33.63606243, 32.25817657, 32.55625695,
            31.91297812, 35.10494283, 38.9636734, 39.99760869, 43.22710136, 47.65145662, 49.62158793, 51.0222279, 52.12292662,
            55.74197831, 61.16892828, 64.08748649, 66.16505509, 66.23313259, 67.08272622, 66.65574969, 64.96502822, 62.84406674,
            60.47223929, 57.01832096, 56.45878373, 58.52340157, 60.87928723, 62.17709008, 62.76672412, 63.48997326, 63.98548763,
            74.09106096};

        x = new ArrayRealVector(xArray);

        yArray = new double[]{
            7.25995316, 8.07860262, 13.13131313, 6.42857143, 3.18791946, 1.95121951, 4.3062201, 7.03363914,
            5.71428571, 4.86486486, 3.09278351, 1.75, 3.80835381, 5.32544379, 4.71910112, 0.10729614, 0.21436227,
            7.70053476, 5.56107249, 4.51552211, 3.96039604, 5.71428571, 4.17690418, 0.78616352, 0, 2.3400936,
            3.65853659, 1.91176471, 3.96825397, 5.34351145, 3.82081686, 3.61675127, 5.93998775, 4.45086705, 3.54178196,
            3.09994655, 1.34784863, 3.83631714, 9.16256158, 8.25812274, 6.75281367, 3.08473253, 1.70454545, 5.2886406,
            2.97134772, 0.89316386, 4.15389854, 2.54985289, 0.28689831, 2.25683408, 3.17065589, 4.97137692, 5.68312285,
            6.32808256, 8.12260536, 6.80368533, 3.36208803, 1.3909694, 4.66441537, 8.04597701, 11.53415454, 8.18273092,
            3.44934261, 4.17165072, 4.01894646, 0.51055609, 4.04997254, 7.2436997, 1.02116142, 1.77810255, 12.42072514,
            7.69558276, 1.13658826, 2.86328545, -4.58863766, 1.71263567, 3.89623103, 2.72307547, 3.00862227, 4.71950134,
            8.41836735, 8.47058824, 1.8076645, -0.14204545, 4.12517781, 4.9863388, 3.18802863, 11.66456494, 8.30039526,
            12.51303441, 5.32900834, 2.72767268, -1.62740899, 0.34828037, 8.11279826, 7.26324238, 5.76131687, 2.86522816,
            9.73177442, 1.15951113, 5.11152416, -5.80607132, -4.72465582, 11.39573071, -1.6509434, 4.31654676, 10.94827586,
            6.83760684, 2.4969697, 5.32166509, 5.14260049, 2.90474156, -3.52843504, 11.27366609, 4.09899459, 2.56315007,
            -10.81130025, 7.2284264, 1.07934103, 3.2409142, 4.681546, 3.95215809, -7.67050192, 2.72710854, 13.87130802,
            -2.47027945, 9.02327054, 0.79860607, -0.93632959, -2.29751345, 5.56630451, 13.15381362, 3.08995764, 2.34469422,
            6.53046764, 0.96441636, 1.15283267, 6.04580484, -8.61821904, -6.48521505, -13.06743323, -1.29512262, 10.88777219,
            8.88721047, 13.05202312, 5.12322323, -3.44357977, 8.07979045, 8.77143922, 17.07087154, 18.45399312, 16.37004079,
            8.0771069, -1.12028302, -10.94215862, -0.89833724, 4.39727493, -0.51235034, 8.74396921, 7.73180459, 3.83138217,
            4.60359196, -0.63053851, 7.19859372, 1.97576291, 2.01592344, -0.90346392, 7.17333954, 2.4760181, 2.33141404,
            6.05820014, 4.37117563, 5.78788162, 6.42042272, 6.51505498, 2.52776116, 4.84210526, 3.10640151, 0.19006054,
            3.35839247, 5.31121836, 5.79426383, -0.55114907, -0.21268329, 5.36530382, 4.59805886, 5.57673355, 3.12455967,
            -0.27327071, 2.53810584, -1.94247728, 4.51889829, 7.18522864, 4.13860212, 3.46312762, 3.20045156, 4.11031955,
            3.57241361, 1.87676739, -0.23400839, 3.39359459, 2.85141968, 4.07466504, 2.51389406, 3.7410515, 4.45626941,
            4.35545904, 4.82617786, 4.13922336, 1.07963656, 1.81366328, 2.49026227, 3.57326847, 3.05451818, 2.67280668,
            2.14161311, 0.4381663, -2.73016994};

        y = new ArrayRealVector(yArray);

        ZArray = new double[][]{
            {5.95533499, 1}, {7.25995316, 1}, {8.07860262, 1}, {13.13131313, 1}, {6.42857143, 1}, {3.18791946, 1}, {1.95121951, 1},
            {4.3062201, 1}, {7.03363914, 1}, {5.71428571, 1}, {4.86486486, 1}, {3.09278351, 1}, {1.75, 1}, {3.80835381, 1},
            {5.32544379, 1}, {4.71910112, 1}, {0.10729614, 1}, {0.21436227, 1}, {7.70053476, 1}, {5.56107249, 1}, {4.51552211, 1},
            {3.96039604, 1}, {5.71428571, 1}, {4.17690418, 1}, {0.78616352, 1}, {0, 1}, {2.3400936, 1}, {3.65853659, 1},
            {1.91176471, 1}, {3.96825397, 1}, {5.34351145, 1}, {3.82081686, 1}, {3.61675127, 1}, {5.93998775, 1}, {4.45086705, 1},
            {3.54178196, 1}, {3.09994655, 1}, {1.34784863, 1}, {3.83631714, 1}, {9.16256158, 1}, {8.25812274, 1}, {6.75281367, 1},
            {3.08473253, 1}, {1.70454545, 1}, {5.2886406, 1}, {2.97134772, 1}, {0.89316386, 1}, {4.15389854, 1}, {2.54985289, 1},
            {0.28689831, 1}, {2.25683408, 1}, {3.17065589, 1}, {4.97137692, 1}, {5.68312285, 1}, {6.32808256, 1}, {8.12260536, 1},
            {6.80368533, 1}, {3.36208803, 1}, {1.3909694, 1}, {4.66441537, 1}, {8.04597701, 1}, {11.53415454, 1}, {8.18273092, 1},
            {3.44934261, 1}, {4.17165072, 1}, {4.01894646, 1}, {0.51055609, 1}, {4.04997254, 1}, {7.2436997, 1}, {1.02116142, 1},
            {1.77810255, 1}, {12.42072514, 1}, {7.69558276, 1}, {1.13658826, 1}, {2.86328545, 1}, {-4.58863766, 1}, {1.71263567, 1},
            {3.89623103, 1}, {2.72307547, 1}, {3.00862227, 1}, {4.71950134, 1}, {8.41836735, 1}, {8.47058824, 1}, {1.8076645, 1},
            {-0.14204545, 1}, {4.12517781, 1}, {4.9863388, 1}, {3.18802863, 1}, {11.66456494, 1}, {8.30039526, 1}, {12.51303441, 1},
            {5.32900834, 1}, {2.72767268, 1}, {-1.62740899, 1}, {0.34828037, 1}, {8.11279826, 1}, {7.26324238, 1}, {5.76131687, 1},
            {2.86522816, 1}, {9.73177442, 1}, {1.15951113, 1}, {5.11152416, 1}, {-5.80607132, 1}, {-4.72465582, 1}, {11.39573071, 1},
            {-1.6509434, 1}, {4.31654676, 1}, {10.94827586, 1}, {6.83760684, 1}, {2.4969697, 1}, {5.32166509, 1}, {5.14260049, 1},
            {2.90474156, 1}, {-3.52843504, 1}, {11.27366609, 1}, {4.09899459, 1}, {2.56315007, 1}, {-10.81130025, 1}, {7.2284264, 1},
            {1.07934103, 1}, {3.2409142, 1}, {4.681546, 1}, {3.95215809, 1}, {-7.67050192, 1}, {2.72710854, 1}, {13.87130802, 1},
            {-2.47027945, 1}, {9.02327054, 1}, {0.79860607, 1}, {-0.93632959, 1}, {-2.29751345, 1}, {5.56630451, 1}, {13.15381362, 1},
            {3.08995764, 1}, {2.34469422, 1}, {6.53046764, 1}, {0.96441636, 1}, {1.15283267, 1}, {6.04580484, 1}, {-8.61821904, 1},
            {-6.48521505, 1}, {-13.06743323, 1}, {-1.29512262, 1}, {10.88777219, 1}, {8.88721047, 1}, {13.05202312, 1}, {5.12322323, 1},
            {-3.44357977, 1}, {8.07979045, 1}, {8.77143922, 1}, {17.07087154, 1}, {18.45399312, 1}, {16.37004079, 1}, {8.0771069, 1},
            {-1.12028302, 1}, {-10.94215862, 1}, {-0.89833724, 1}, {4.39727493, 1}, {-0.51235034, 1}, {8.74396921, 1}, {7.73180459, 1},
            {3.83138217, 1}, {4.60359196, 1}, {-0.63053851, 1}, {7.19859372, 1}, {1.97576291, 1}, {2.01592344, 1}, {-0.90346392, 1},
            {7.17333954, 1}, {2.4760181, 1}, {2.33141404, 1}, {6.05820014, 1}, {4.37117563, 1}, {5.78788162, 1}, {6.42042272, 1},
            {6.51505498, 1}, {2.52776116, 1}, {4.84210526, 1}, {3.10640151, 1}, {0.19006054, 1}, {3.35839247, 1}, {5.31121836, 1},
            {5.79426383, 1}, {-0.55114907, 1}, {-0.21268329, 1}, {5.36530382, 1}, {4.59805886, 1}, {5.57673355, 1}, {3.12455967, 1},
            {-0.27327071, 1}, {2.53810584, 1}, {-1.94247728, 1}, {4.51889829, 1}, {7.18522864, 1}, {4.13860212, 1}, {3.46312762, 1},
            {3.20045156, 1}, {4.11031955, 1}, {3.57241361, 1}, {1.87676739, 1}, {-0.23400839, 1}, {3.39359459, 1}, {2.85141968, 1},
            {4.07466504, 1}, {2.51389406, 1}, {3.7410515, 1}, {4.45626941, 1}, {4.35545904, 1}, {4.82617786, 1}, {4.13922336, 1},
            {1.07963656, 1}, {1.81366328, 1}, {2.49026227, 1}, {3.57326847, 1}, {3.05451818, 1}, {2.67280668, 1}, {2.14161311, 1},
            {0.4381663, 1}};

        Z = new Array2DRowRealMatrix(ZArray);

    }

    public RealVector getX() {
        return x;
    }

    public RealVector getY() {
        return y;
    }

    public RealMatrix getZ() {
        return Z;
    }

}
