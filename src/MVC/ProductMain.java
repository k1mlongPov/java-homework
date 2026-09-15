package MVC;


public class ProductMain {
    private ProductController controller = new ProductController();
    private ProductView view = new ProductView();
    void main() {
        int option;
        do {
             option = view.showMenuAndGetChoice();
            switch (option) {
                case 1 -> {
                    int trackIndex = 0;
                    view.displayMessage("===> Add Product");
                    int numOfProducts =  ProductView.inputInteger("Enter number of products ");
                    while (numOfProducts < 0) {
                        view.errorMessage("Number of products can not be under 0!");
                        numOfProducts =  ProductView.inputInteger("Enter number of products ");
                    }
                    for (int i = 0; i < numOfProducts; i++) {
                        view.displayMessage("===> Product #" + i);
                        controller.createCtrl();
                    }
                }

                case 2 -> {
                    view.displayMessage("===> Search Product");
                    controller.getByIdCtrl();
                }

                case 3 -> {
                    controller.getAllCtrl();
                }

                case 4 -> {
                    view.displayMessage("===> Update Product");
                    controller.updateCtrl();
                }

                case 5 -> {
                    view.displayMessage("===> Delete Product");
                    controller.deleteCtrl();
                }

                case 6 -> view.displayMessage("Exiting the program...");

                default -> view.errorMessage("Please choose the valid option!");

            }
        }while (option != 6);
    }
}
