package global.goit;

import global.goit.database.DatabaseQueryService;
import global.goit.entity.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DatabaseQueryService queryService = new DatabaseQueryService();

        List<MaxProjectCountClient> maxProjectCountClients = queryService.findMaxProjectsClient();
        System.out.println("=".repeat(100) + "\n");
        System.out.println("Max Project Count Clients: "+"\n");
        maxProjectCountClients.forEach(System.out::println);
        System.out.println("=".repeat(100) + "\n");

        List<MaxSalaryWorker> maxSalaryWorkers = queryService.findMaxSalaryWorker();
        System.out.println("Max Salary Workers: "+"\n");
        maxSalaryWorkers.forEach(System.out::println);
        System.out.println("=".repeat(100) + "\n");

        List<YoungestEldestWorkers> youngestEldestWorkers = queryService.findYoungestEldestWorkers();
        System.out.println("Youngest Eldest Workers: "+"\n");
        youngestEldestWorkers.forEach(System.out::println);
        System.out.println("=".repeat(100) + "\n");

        List<LongestProject> longestProjects = queryService.findLongestProject();
        System.out.println("Longest Projects: " + "\n");
        longestProjects.forEach(System.out::println);
        System.out.println("=".repeat(100) + "\n");

        List<ProjectPrices> projectPrices = queryService.printProjectPrices();
        System.out.println("Project Prices: " + "\n");
        projectPrices.forEach(System.out::println);
    }
}
