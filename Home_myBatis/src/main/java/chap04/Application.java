package chap04;

import com.sun.source.tree.WhileLoopTree;

import java.util.*;

public class Application {
    public static Scanner sc = new Scanner(System.in);
    public static MenuService menuService = new MenuService();

    public static void main(String[] args) {
        do{
            System.out.println("==== MyBatis 동적 SQL ====");
            System.out.println("1.if 확인하기 ▼\n2.choose(when, otherwise) 확인하기\n3.foreach 확인하기\n4.trim(where,set)확인하기 ▼\n9.종료");
            System.out.print("메뉴 선택 : ");
            int no = sc.nextInt();
            sc.nextLine();

            switch (no){
                case 1 : ifSubMenu(); break;
                case 2 : menuService.chooseSubMenu(inputCategory()); break;
                case 3 : menuService.foreachSubMenu(createRandomMenuCodeList()); break;
                case 4 : trimSubMenu(); break;
                case 9 :
                    System.out.println("프로그램 종료"); return;
            }
        } while(true);
    }

    private static void ifSubMenu() {
        do{
            System.out.println("==== if 서브메뉴 ====");
            System.out.println("1. 원하는 금액대에 적합한 추천 메뉴 목록 보여주기");
            System.out.println("2. 메뉴이름 혹은 카테고리명으로 검색하여 메뉴 목록 보여주기");
            System.out.println("9. 이전 메뉴로");
            System.out.print("메뉴 선택 : ");
            int no = sc.nextInt();
            sc.nextLine();

            switch (no){
                case 1 : menuService.selectMenuByPrice(inputPrice()); break;
                case 2 : menuService.searchMenu(inputSearchCriteria()); break;
                case 9 : return;
            }
        }while (true);
    }

    private static void trimSubMenu() {
        do{
            System.out.println("==== trim 서브메뉴 ====");
            System.out.println("1. 검색조건이 있는 경우 메뉴코드로 조회, 없으면 전체 조회");
            System.out.println("2. 메뉴명 혹은 카테고리 코드로 검색, 메뉴와 카테고리가 일치하는 경우도 검색, 검색조건이 없는 경우 전체검색");
            System.out.println("3. 원하는 메뉴 정보만 수정");
            System.out.println("9. 이전 메뉴로");
            System.out.print("메뉴 선택 : ");
            int no = sc.nextInt();
            sc.nextLine();

            switch (no){
                case 1 : menuService.searchMenuByCodeOrSearchAll(inputAllOrOne()); break;
                case 2 : menuService.searchMenuByNameOrCategory(inputSearchCriteriaMap()); break;
                case 3 : menuService.modifyMenu(inputChangeInfo()); break;
                case 9 : return;
            }

        } while(true);
    }

    private static int inputPrice() {
        System.out.print("검색할 최대금액 입력 : ");
        int price = Integer.parseInt(sc.nextLine());

        return price;
    }

    private static SearchCriteria inputSearchCriteria() {
        SearchCriteria searchCriteria = new SearchCriteria();

        label: while(true){
            System.out.print("검색기준 입력(name or category) : ");
            String condition = sc.nextLine();

            if(condition.equals("name") || condition.equals("category")) {
                searchCriteria.setCondition(condition);
                break;
            }else{
                System.out.println("name 또는 category 중에서 입력해주세요");
                continue label;
            }
        }

        System.out.print("검색어 입력 : ");
        String value = sc.nextLine();
        searchCriteria.setValue(value);

        return searchCriteria;
    }

    private static String inputCategory() {
        System.out.println("카테고리 상위 분류별 메뉴 보기 (식사, 음료, 디저트)");
        System.out.print("메뉴 선택 : ");
        String category = sc.nextLine();

        return category;
    }

    private static Set<Integer> createRandomMenuCodeList() {
        System.out.println("랜덤한 메뉴 5개 추출해서 조회하기");

        Set<Integer> code = new HashSet<>();
        while(code.size() < 5){
            int random = (int)(Math.random() * 23) + 2;
            code.add(random);
        }

        return code;
    }

    private static SearchCriteria inputAllOrOne() {
        System.out.print("검색 조건 입력 여부 (예/아니오) : ");
        String answer = sc.nextLine();

        SearchCriteria searchCriteria = new SearchCriteria();

        if(answer.equals("예")){
            System.out.print("검색할 메뉴코드 입력 : ");
            String code = sc.nextLine();

            searchCriteria.setCondition("menuCode");
            searchCriteria.setValue(code);
        }

        return searchCriteria;
    }

    private static Map<String, Object> inputSearchCriteriaMap() {
        System.out.print("검색 조건 입력(category / name / both / null) : ");
        String condition = sc.nextLine();

        Map<String, Object> search = new HashMap<>();
        if(condition.equals("category")){
            System.out.print("검색할 카테고리 코드 입력 : ");
            int categoryValue = Integer.parseInt(sc.nextLine());

            search.put("categoryValue", categoryValue);
        }else if(condition.equals("name")){
            System.out.print("검색할 이름 입력 : ");
            String nameValue = sc.nextLine();

            search.put("nameValue", nameValue);
        }else if(condition.equals("both")){
            System.out.print("검색할 이름 입력 : ");
            String nameValue = sc.nextLine();
            System.out.print("검색할 카테고리 코드 입력 : ");
            int categoryValue = Integer.parseInt(sc.nextLine());

            search.put("nameValue", nameValue);
            search.put("categoryValue", categoryValue);
        }
        return search;
    }

    private static Map<String, String> inputChangeInfo() {
        Map<String, String> parameter = new HashMap<>();

        label1: while(true){
            System.out.print("변경할 메뉴 코드 입력 : ");
            String code = sc.nextLine().trim();

            if(code == null || code.length() == 0) continue label1;

            parameter.put("code", code);
            break;
        }

        label2: while(true){
            System.out.print("변경할 메뉴 이름 입력 : ");
            String name = sc.nextLine().trim();
            System.out.print("변경할 메뉴 가격 입력 : ");
            String price = sc.nextLine().trim();
            System.out.print("변경할 카테고리 코드 입력 : ");
            String categoryCode = sc.nextLine().trim();
            System.out.print("판매여부 입력(Y/N) : ");
            String order = sc.nextLine().trim();

            if((name == null || name.isEmpty()) && (price == null || price.isEmpty()) && (categoryCode == null || categoryCode.isEmpty()) && (order == null || order.isEmpty())){
                System.out.println("최소 1개 이상의 정보를 입력해야합니다.");
                continue label2;
            }

            parameter.put("name", name);
            parameter.put("price", price);
            parameter.put("categoryCode", categoryCode);
            parameter.put("order", order);

            break;
        }

        return parameter;
    }
}
