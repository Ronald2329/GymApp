-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 20-Dez-2023 às 14:43
-- Versão do servidor: 10.4.25-MariaDB
-- versão do PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `gymapp`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `clientes`
--

CREATE TABLE `clientes` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `idade` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `telefone` varchar(15) DEFAULT NULL,
  `tipo_plano` enum('mensal','bimestral','semestral','anual') DEFAULT NULL,
  `ultima_alteracao` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `sexo` enum('Masculino','Feminino') DEFAULT NULL,
  `matricula_status` enum('matriculado','trancado','desmatriculado') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `clientes`
--

INSERT INTO `clientes` (`id`, `nome`, `idade`, `email`, `telefone`, `tipo_plano`, `ultima_alteracao`, `sexo`, `matricula_status`) VALUES
(2, 'Jõao', 23, 'joao123@gmail.com', '75999999', 'bimestral', '2023-12-20 12:53:19', 'Masculino', 'matriculado'),
(3, 'Diule guerrinha', 1000, 'diuleguerrinha123@gmail.com', '71999999', 'anual', '2023-12-20 13:31:18', 'Feminino', 'matriculado'),
(4, 'Lucas', 34, 'lucas123@gmail.com', '321', 'mensal', '2023-12-15 13:03:45', 'Masculino', 'matriculado'),
(5, 'Ronald Oliveira Nepomuceno', 21, 'developerronald1@gmail.com', '234234234', 'mensal', '2023-12-20 01:51:33', 'Masculino', 'matriculado'),
(6, 'Edna de Santana Oliveira', 52, 'edednapsico9@gmail.com', '7599917', 'anual', '2023-12-20 02:05:48', 'Feminino', 'desmatriculado'),
(7, 'Lucas o narigudo kk', 27, 'lucas123@gmail.com', '762342342', 'semestral', '2023-12-20 13:30:28', 'Masculino', 'trancado');

-- --------------------------------------------------------

--
-- Estrutura da tabela `pagamentos`
--

CREATE TABLE `pagamentos` (
  `id_pagamento` int(11) NOT NULL,
  `id_cliente` int(11) DEFAULT NULL,
  `valor` decimal(10,2) DEFAULT NULL,
  `data_pagamento` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `pagamentos`
--

INSERT INTO `pagamentos` (`id_pagamento`, `id_cliente`, `valor`, `data_pagamento`) VALUES
(1, 2, '800.00', '2023-12-04'),
(2, 2, '80.00', '2023-12-20'),
(3, 2, '80.00', '2023-03-20'),
(4, 2, '160.00', '2024-09-20'),
(5, 7, '80.00', '2023-12-20'),
(6, 7, '800.00', '2023-12-19'),
(7, 3, '231.00', '2023-12-20');

-- --------------------------------------------------------

--
-- Estrutura da tabela `treinos`
--

CREATE TABLE `treinos` (
  `id_treino` int(11) NOT NULL,
  `id_cliente` int(11) DEFAULT NULL,
  `dia` enum('domingo','segunda','terca','quarta','quinta','sexta','sabado') DEFAULT NULL,
  `nome_exercicio` varchar(255) DEFAULT NULL,
  `quantidade_series` int(11) DEFAULT NULL,
  `repeticoes` int(11) DEFAULT NULL,
  `tempo_descanso` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `treinos`
--

INSERT INTO `treinos` (`id_treino`, `id_cliente`, `dia`, `nome_exercicio`, `quantidade_series`, `repeticoes`, `tempo_descanso`) VALUES
(2, 2, 'domingo', 'Barra fixa ', 4, 15, 120),
(3, 7, 'domingo', 'Barra fixa', 4, 15, 120),
(4, 7, 'domingo', 'Barra pegada pronada', 4, 10, 120),
(5, 7, 'segunda', 'asd', 2, 12, 32),
(6, 7, 'terca', 'asdasd', 3, 12, 60),
(7, 7, 'quarta', 'asdasdasd', 3, 23, 124),
(8, 7, 'quinta', 'asdfawerq3', 2, 12, 50),
(9, 7, 'sexta', 'asdasdaAsd', 6, 8, 120);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `pagamentos`
--
ALTER TABLE `pagamentos`
  ADD PRIMARY KEY (`id_pagamento`),
  ADD KEY `id_cliente` (`id_cliente`);

--
-- Índices para tabela `treinos`
--
ALTER TABLE `treinos`
  ADD PRIMARY KEY (`id_treino`),
  ADD KEY `id_cliente` (`id_cliente`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de tabela `pagamentos`
--
ALTER TABLE `pagamentos`
  MODIFY `id_pagamento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de tabela `treinos`
--
ALTER TABLE `treinos`
  MODIFY `id_treino` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `pagamentos`
--
ALTER TABLE `pagamentos`
  ADD CONSTRAINT `pagamentos_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id`);

--
-- Limitadores para a tabela `treinos`
--
ALTER TABLE `treinos`
  ADD CONSTRAINT `treinos_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
