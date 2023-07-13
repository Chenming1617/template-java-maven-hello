package org.example;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Mygoods implements Myfunction {
    private Map<String, Goods> goodsMap; // 用Map来存储商品对象，方便查找
    private static final String ACTION_NAME = "goods";

    private Scanner scanner = null;
    Scanner s = new Scanner(System.in);

    public Mygoods() {
        goodsMap = new HashMap<String, Goods>();
    };

    public Mygoods(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getfunctionName() {
        return Mygoods.ACTION_NAME;
    }

    @Override
    public void run(String[] args) {
        System.out.print("**********欢迎进入商品管理子菜单**********\n");
        String userInput = "";

        while (true) {
            System.out.println("请输入你的指令,0退出,1列出商品信息,2添加商品信息,3修改商品信息,4删除商品信息,5查询商品信息");
            System.out.print("你当前在***商品管理***的三级子菜单下 >");
            userInput = s.nextLine();

            if (userInput.equals("0")) {
                break;
            }
            if (userInput.equals("1")) {
                displayAllGoods();
            }
            if (userInput.equals("2")) {// add information
                System.out.println("You select to add informations of Goods");
                System.out.println("please enter the name of goods");
                String name = s.next();

                System.out.println("plesae enter the price of goods");
                Double price = s.nextDouble();
                String delete = s.nextLine();
                System.out.println("plesae enter the goodsId of goods");
                String Id = s.nextLine();

                Goods good = new Goods(Id, name, price);
                addGoods(good);
            }
            if (userInput.equals("3")) {
                System.out.println("You select to alter the Goods,plesae enter the goodsId of goods");
                String Id = s.nextLine();
                alterGoods(Id);
            }
            if(userInput.equals("4")){
                System.out.println("You select to delete the Goods,plesae enter the goodsId of goods");
                String Id = s.nextLine();
                removeGoods(Id);
            }
            if(userInput.equals("5")){
                System.out.println("You select to search the GoodsbyId");
                System.out.println("Please enter the GoodId");
                String Id = s.nextLine();
                findGoods(Id);
            }
        }
    }


    public void addGoods(Goods goods) {
        goodsMap.put(goods.getGoodsId(), goods);
    }

    public void removeGoods(String goodsId) {
        Goods removegoods = goodsMap.remove(goodsId);
        if (removegoods == null) {
            System.out.println("Delete failed,item does not exist");
        } else {
            System.out.println("Have deleted " + removegoods.getGoodsId()+" "+removegoods.getName());
        }
    }

    public void displayAllGoods() {
        if (goodsMap.isEmpty()) {
            System.out.println("当前没有商品信息！");
        } else {
            System.out.println("商品编号\t商品名\t商品价格");
            for (Goods goods : goodsMap.values()) {
                System.out.println(goods.getGoodsId() + "\t" + "\t" + goods.getName() + "\t" + goods.getPrice());
            }
        }
    }

    public Goods findGoods(String goodsId) {
        if (goodsMap.containsKey(goodsId)) {
            System.out.println("GoodId "+goodsId+ "\t"+"GoodName "+goodsMap.get(goodsId).getName()
            + "\t"+"GoodPrice "+goodsMap.get(goodsId).getPrice());
            System.out.println("Search Success!");
            return goodsMap.get(goodsId);
        } else {
            System.out.println("No information found for item " + goodsId);
            return null;
        }
    }
    public Goods findGoods1(String goodsId) {
        if (goodsMap.containsKey(goodsId)) {
            return goodsMap.get(goodsId);
        } else {
            System.out.println("No information found for item " + goodsId);
            return null;
        }
    }

    public ArrayList<Goods> findGoodsByName(String goodsName) {
        ArrayList<Goods> goodsList = new ArrayList<>();

        if (goodsMap.isEmpty()) {
            System.out.println("当前没有商品信息！");
        } else {
            for (Goods goods : goodsMap.values()) {
                if (goods.getName().contains(goodsName)) {
                    goodsList.add(goods);
                }
            }

            if (goodsList.isEmpty()) {
                System.out.println("未找到名称包含 \"" + goodsName + "\" 的商品信息");
            } else {
                System.out.printf("名称包含 \"%s\" 的商品有 %d 个：\n", goodsName, goodsList.size());
                System.out.printf("商品编号：\t商品名：\t\t价格：\n");
                for (Goods goods : goodsList) {
                    System.out.printf("%-10s\t%-20s\t%-10.2f\t%-50s\n", goods.getGoodsId(), goods.getName(),
                            goods.getPrice());
                }
            }
        }
        return goodsList;
    }

    public void alterGoods(String alterGoodsId) {
        if (findGoods1(alterGoodsId) == null) {
            System.out.println("the goods does not exist!");
        } 
        else {
            while (true) {
                System.out.println("What do you want to alter,0 GoodsID,1 GoodsPrice,2 GoodsName,3 exit");
                int num = s.nextInt();
                if(num==3) break;
                String delete = s.nextLine();
                switch (num) {
                    case 0:
                        System.out.println("Please enter the GoodsID");
                        String ID = s.next();
                        findGoods1(alterGoodsId).setGoodsId(ID);
                        break;
                    case 1:
                        System.out.println("Please enter the GoodsPrice");
                        Double Price = s.nextDouble();
                        String delete2 = s.nextLine();// tools
                        findGoods1(alterGoodsId).setPrice(Price);
                        break;
                    case 2:
                        System.out.println("Please enter the GoodsName");
                        String Name = s.nextLine();
                        findGoods1(alterGoodsId).setName(Name);
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Sorry,what you entered exceeds 0123");
                        break;
                }
                
                goodsMap.put(alterGoodsId, findGoods1(alterGoodsId));
            }
            System.out.println("success");
        }
    }

}
